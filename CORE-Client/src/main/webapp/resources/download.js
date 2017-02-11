define(function () {
    return function (fileName, content) {
        $('body').append('<a id="downloader" href="#"></a>');
        var downloader = $('a#downloader');
        $(downloader).attr({
            download: fileName,
            href: 'data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,' + content
        });
        $(downloader)[0].click();
        $(downloader).remove();
    }
});