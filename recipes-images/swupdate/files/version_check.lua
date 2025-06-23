function preinstall()
  local new_version = "1.0.0" -- identisch mit software.version
  local current_version_file = "/etc/version.txt"

  local file = io.open(current_version_file, "r")
  if file then
    local current = file:read("*l")
    file:close()
    if current == new_version then
      print("SWUpdate: gleiche Version, Abbruch.")
      return 1 -- Fehler → Update wird abgebrochen
    else
      print("SWUpdate: neue Version erkannt.")
      return 0 -- Update durchführen
    end
  else
    print("SWUpdate: Version-Datei nicht gefunden, Update wird durchgeführt.")
    return 0
  end
end
