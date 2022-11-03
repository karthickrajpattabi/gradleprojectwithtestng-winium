$download_url = "http://XXXXXXXXX.exe"
$local_path = "D:\rigDownload\NECTAR-UCF-64bit-Installer-2022.2.exe"
$user = "user"
$pass = "pass"
 [Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
$WebClient = New-Object System.Net.WebClient
$WebClient.Credentials = New-Object System.Net.NetworkCredential($user, $pass)
$WebClient.DownloadFile($download_url, $local_path)