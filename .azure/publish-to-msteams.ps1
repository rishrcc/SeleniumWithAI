$buildId = $env:BUILD_BUILDID
$buildUrl = "$env:SYSTEM_TEAMFOUNDATIONCOLLECTIONURI/$env:SYSTEM_TEAMPROJECT/_build/results?buildId=$buildId"

$contents = Get-Content -Path qa_auto\OneyFrance\target\surefire-reports\Runner.TestRunner.txt -Raw -Encoding ascii

$teamsMessage = @{
    "attachments"     = @(
        @{
            "contentType" = "AdaptiveCard"
            "content"     = @{
                "type" = "AdaptiveCard"
                "body" = @(
                    @{
                        "type"  = "FactSet"
                        "facts" = @(
                            @{
                                title  = 'Pipeline'
                                value  = "[Oney France]"
                            },
                            @{
                                title  = 'Test results'
                                value  = "[$buildId]($BuildUrl)"
                            }
                        )
                    },
                    @{
                        "type"   = "TextBlock"
                        "text"   = "----- Details -----"
                        "weight" = "Bolder"
                    },
                    @{
                        "type" = "TextBlock"
                        "text" = "$contents"
                        "wrap" = "true"
                    }
                )
            }
        }
    )
}

# Second, send the message to teams
# Convert message to json
$jsonObject = (ConvertTo-Json $teamsMessage -Depth 100)

# Log het jsonObject
$jsonObject | Out-Host

# Send teams message
$response = Invoke-RestMethod -Method POST -ContentType 'Application/Json' -Body $jsonObject -Uri "https://prod-74.westeurope.logic.azure.com:443/workflows/40b1d3cecaf646d78e6020b54af567f7/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=UAnC2Y0BOzMV-leyuahrRsC3A-ehS5yubUESjjEbPIc"

if ($response -ne 1) {
    Write-Warning "Response: $response"
    Write-Host "##vso[task.complete result=SucceededWithIssues;]"
}
