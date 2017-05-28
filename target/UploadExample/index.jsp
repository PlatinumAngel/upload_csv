<html>
<link rel="stylesheet" href="css/styles.css"/>
<link rel="stylesheet" href="css/jquery-filestyle.min.css"/>
<link rel="stylesheet" href="css/jquery-confirm.min.css"/>

<body>
<script type="text/javascript"
                 src="js/jquery-3.2.1.min.js" ></script>
<script type="text/javascript"
                 src="js/handlebars-v4.0.10.js" ></script>
<script type="text/javascript" src="js/HandlebarsArrayHelper.js"></script>
<script type="text/javascript"
                 src="js/HandlebarsTemlateUtils.js"></script>
<script type="text/javascript"
                 src="js/LocalFileReader.js"></script>
<script type="text/javascript"
                 src="js/CsvFileParser.js"></script>
<script type="text/javascript"
                 src="js/jquery-confirm.min.js"></script>


<script id="handlebars-table-template" type="text/x-handlebars-template">
    <div class="elementWithTooltip"><p>File preview:</p>
        <span class="tooltip">Up to 10 first lines of uploaded file</span>
    </div>
    <div class="divTable">
        <div class="divTableBody">
            {{#limitation rows 10}}
                <div class="divTableRow">
                {{#each columns}}
                    <div class="divTableCell">{{this}}</div>
                {{/each}}
                </div>
            {{/limitation}}
        </div>
    </div>
    <div style="float:right;">
        <button type="button" id="submit" onclick="sendContent()">
            <span>Send </span>
        </button>
    </div>
</script>

<h2>Please upload csv file here</h2>
<form id="form" enctype="multipart/form-data" method="post"
            onsubmit="return false;">

<input id="fileInput" type="file"  accept=".csv"
    class="jfilestyle" data-buttonBefore="true"
    data-buttonText="<span class='glyphicon glyphicon-folder-open'>Choose file</span>"
    />
    <div id="preview"></div>
</form>

<script type="text/javascript"
                 src="js/FooterViewConfiguration.js"></script>
<script type="text/javascript" src="js/jquery-filestyle.min.js"></script>
</body>
</html>
