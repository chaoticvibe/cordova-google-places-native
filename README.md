### Cordova Place Autocomplete Plugin

[![npm version](https://badge.fury.io/js/cordova-plugin-place-autocomplete.svg)](https://badge.fury.io/js/cordova-plugin-place-autocomplete)

**`Install:`**
```sh
cordova plugin add cordova-plugin-place-autocomplete --save

```


**`Usage:`**
```javascript
var onPlaceAutocompleteResult = function(place) {
  //
};

var onPlaceAutocompleteError = function(error) {
  //
};

window.cordova.plugins.gms.places.PlaceAutocompleteDialog.show(onPlaceAutocompleteResult, onPlaceAutocompleteError);

```


**`Place model:`**
```javascript
{
  name: String,
  coordinates: {
    latitude: Double,
    longitude: Double
  }
}
```


**`AndroidManifest.xml:`**

```xml
<application ...>
  <meta-data android:name="com.google.android.geo.API_KEY" android:value="YOUR_API_KEY" />
  <uses-library android:name="org.apache.http.legacy" android:required="false" />
</application>
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

```
