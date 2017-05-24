Handlebars.registerHelper('limitation', function(elements, max, options) {
    if(!elements || elements.length == 0)
        return options.inverse(this);
    var result = [ ];
    for(var i = 0; i < max && i < elements.length; ++i)
        result.push(options.fn(elements[i]));
    return result.join('');
});