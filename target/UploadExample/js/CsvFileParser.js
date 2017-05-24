var CsvFileParser = function() {
    var VALID_LINE_PATTERN = /^\s*(?:'[^'\\]*(?:\\[\S\s][^'\\]*)*'|"[^"\\]*(?:\\[\S\s][^"\\]*)*"|[^,'"\s\\]*(?:\s+[^,'"\s\\]+)*)\s*(?:,\s*(?:'[^'\\]*(?:\\[\S\s][^'\\]*)*'|"[^"\\]*(?:\\[\S\s][^"\\]*)*"|[^,'"\s\\]*(?:\s+[^,'"\s\\]+)*)\s*)*$/;
    var VALUE_PATTERN = /(?!\s*$)\s*(?:'([^'\\]*(?:\\[\S\s][^'\\]*)*)'|"([^"\\]*(?:\\[\S\s][^"\\]*)*)"|([^,'"\s\\]*(?:\s+[^,'"\s\\]+)*))\s*(?:,|$)/g;
    var END_OF_LINE = /\r\n|\n/;

    this.preparedContent = {
        "rows" : []
    };

    this.checkEmpty = function(lineText, returnValue) {
        if (/,\s*$/.test(lineText)) {
            returnValue.push('');
        }
    }
    this.parseLine = function(lineText) {
        if (!VALID_LINE_PATTERN.test(lineText)) {
            return {};
        }
        var returnValue = [];
        lineText.replace(VALUE_PATTERN, function(match0, match1, match2, match3) {
              if (match1 !== undefined) {
                returnValue.push(match1.replace(/\\'/g, "'"));
              }
              else if (match2 !== undefined) {
                returnValue.push(match2.replace(/\\"/g, '"'));
              }
              else if (match3 !== undefined) {
                returnValue.push(match3);
              }
              return ['']; // Return empty string.
          });
        this.checkEmpty(lineText, returnValue);
        return returnValue;
    }

    this.addLineToParsedContent = function(line) {
        this.preparedContent.rows.push({ "columns" : this.parseLine(line)})
    }

    this.parseContent = function(string) {
        var lines = string.split(END_OF_LINE);
        while (lines.length>0) {
            this.addLineToParsedContent(lines.shift());
        }
        return this.preparedContent;
    }
}
