var parsedCsv;

function fillPreviewTemplateWithFile(file) {
    new LocalFileReader().readSingleFile(file, function(fileContent){
        parsedCsv = new CsvFileParser().parseContent(fileContent);
        fillTemplate("#handlebars-table-template", "#preview", parsedCsv);
    });
}

function submitCsvContent() {
    $.ajax({
        type : "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url : "api/upload",
        data : JSON.stringify(parsedCsv),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            fillTemplate("#handlebars-table-template", "#preview", {});
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}

document.getElementById('fileInput').addEventListener('change', fillPreviewTemplateWithFile, false);

function sendContent() {
    if(confirm("Do you want import this data?") === true) {
        submitCsvContent();
    }
}