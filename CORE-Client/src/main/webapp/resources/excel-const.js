define(function () {
    var Consts = {
        XlPageSize: [
            {name: 'A3', value: 8},
            {name: 'A4', value: 9},
            {name: 'B4', value: 12},
            {name: 'B5', value: 13},
            {name: 'Letter', value: 1}    
            // more value can be found at http://msdn.microsoft.com/en-us/library/office/ff839964(v=office.14).aspx
        ],
        Orientation: [
            {name: 'Portrait', value: 'portrait'},
            {name: 'Landscape', value: 'landscape'}
        ]
    };
    return Consts;
});