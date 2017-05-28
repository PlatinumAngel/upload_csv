<html>
<link rel="stylesheet" href="css/styles.css">
<style>

body {
    background-color: #CCCCCC;
}

/**/

#submit {
  border-radius: 4px;
  background-color: #2c6fb7;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 28px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

#submit span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

#submit span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

#submit:hover span {
  padding-right: 25px;
}

#submit:hover span:after {
  opacity: 1;
  right: 0;
}

</style>

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
    <p>File preview:</p>
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

    <input id="fileInput" type="file" accept=".csv"
        title="Choose a file" />
    <div id="preview"></div>
</form>

<script type="text/javascript"
                 src="js/FooterViewConfiguration.js"></script>
</body>
</html>
