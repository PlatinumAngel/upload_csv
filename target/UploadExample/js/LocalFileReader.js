var LocalFileReader = function() {

    this.readContext = function(file, callback) {
        var fileReader = new FileReader();
        var returnContent;
        fileReader.onload = function (e) {
            returnContent = e.target.result;
            callback(returnContent);
        }
        fileReader.readAsText(file);
    }

    this.readSingleFile = function(evt, callback) {
        var firstFile = evt.target.files[0];
        if(firstFile) {
            console.log(firstFile);
            this.readContext(firstFile,  function(fileContent) {
                callback(fileContent);
            });
        } else {
            console.warn("no file");
        }
    }
}