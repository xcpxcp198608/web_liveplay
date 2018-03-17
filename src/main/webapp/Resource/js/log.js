$(function () {

    var tBody = $('#tb').get(0).tBodies[0];
    for(var i = 0 ; i < tBody.rows.length; i ++){
        var btMore = tBody.rows[i].cells[4].children[0];
        btMore.onclick =  function () {
            var channelName = this.parentNode.parentNode.cells[1].innerHTML;
            window.open('/liveplay/log/detail/?channelName='+ channelName, '_blank')
        }
    }

});