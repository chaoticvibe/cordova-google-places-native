
var exec = require('cordova/exec');

var PlaceAutocompleteDialog = {

  show: function(onSuccess, onError) {
    exec(onSuccess, onError, 'PlaceAutocompleteDialog', 'show', []);
  }

};

module.exports = PlaceAutocompleteDialog;
