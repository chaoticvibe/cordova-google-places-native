### Cordova Places Native

This plugis is focused in "google official places autocomplete api", but you can found another functions or sadly can't found some functions... 
Feel free to open a issue or pull request... if you face any bug or unexpected behavior, or new feature suggestion, open a issue! Thank you!

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
