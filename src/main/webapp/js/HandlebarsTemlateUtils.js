function fillTemplate(templateName, targetAreaId, content) {
    var source   = $(templateName).html();
    var template = Handlebars.compile(source);
    $(targetAreaId).html(template(content));
}