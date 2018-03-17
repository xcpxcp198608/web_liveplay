addEventListener('load', function () {
    document.oncontextmenu = function () {
        return false
    }
}, false);

function showErrorMessage() {
    $('#progress_div').css('display', 'none');
    $('#status_div').css('display','block');
    $('#status_message').html('request error');
    setTimeout(function () {
        $('#status_div').css('display','none');
    }, 1500)
}

function showSuccessMessage(message) {
    $('#progress_div').css('display', 'none');
    $('#status_div').css('display','block');
    $('#status_message').html(message);
    setTimeout(function () {
        $('#status_div').css('display','none');
    }, 1500)
}