<html>
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

<script id="handlebars-table-template" type="text/x-handlebars-template">
    File preview:<br/>
    {{#limitation rows 10}}
        {{#each columns}}
            {{this}} {{#unless @last}} | {{/unless}}
        {{/each}}
        <br/>
    {{/limitation}}
    <input id="submit" type="submit" value="Send"  onclick="sendContent()"/>
</script>

<h2>Please upload csv file here</h2>

<form id="form" enctype="multipart/form-data" method="post"
            onsubmit="return false;">
    <p>
        Please specify a csv file:<br/>
        <input id="fileInput" type="file" accept=".csv">
    </p>
    <div id="preview"></div>
</form>

<script type="text/javascript"
                 src="js/FooterViewConfiguration.js"></script>
</body>
</html>
