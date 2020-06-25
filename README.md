### Cordova Places Native

This plugis is focused in "google official places autocomplete api", but you can found another functions or sadly can't found some functions... 
Feel free to commit or open an issue or pull request... please repport any bug or unexpected behavior. Thank you!

This is free, but does not have any guarantee to work. You can use it for free in your commercial projects.

**`Basic Usage Examples:`**
```javascript
var onPlaceAutocompleteResult = function(place) {
  //ut
}; B

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
