var parsedCsv;

function fillPreviewTemplateWithFile(file) {
    new LocalFileReader().readSingleFile(file, function(fileContent){
        parsedCsv = new CsvFileParser().parseContent(fileContent);
        fillTemplate("#handlebars-table-template", "#preview", parsedCsv);
    });
}

document.getElementById('fileInput').addEventListener('change', fillPreviewTemplateWithFile, false);

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
            afterSaveAction();
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE", e);
        }
    });
}

function afterSaveAction() {
    $.alert({
        title: 'Saved',
        content: 'Content is saved on server',
        useBootstrap: false,
        boxWidth: '30%'
    });
}

function sendContent() {
    $.confirm({
        boxWidth: '30%',
        useBootstrap: false,
        title: 'Sending file',
        content: 'Do you want to save content of this file?',
        autoClose: 'cancelAction|10000',
        buttons: {
            saveFile: {
                text: 'Save',
                action: function () {
                    submitCsvContent();
                }
            },
            cancelAction: {
                text: 'Cancel',
                action: function () {
                }
            }
        }
    });
}
