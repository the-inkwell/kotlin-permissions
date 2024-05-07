# Manages permissions

### Integrate

add `implementation("eu.codlab:kotlin-permissions:${extVersion}")` to your dependencies block.

### Configure

In your Activities call (for instance onResume) : `PermissionsController.setActivity(this)`

Note : if you miss this part, actions to ask for permissions or getting the full permission status will hang
until you configure it properly

isGranted is the only method which will be able to be used outside of any specific configurations.

### Usage

Inside a coroutine, call :

```
AuthManager.createSession(externalId) { { _: String?, _: Boolean ->
  // here, manage network call to bring a new Client Access Token v2
  return ""
}

```
