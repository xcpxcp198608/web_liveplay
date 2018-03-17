$(function () {
    $('#username').keyup(function () {
        checkUserName()
    });

    $('#username').blur(function () {
       checkUserName()
    });

    $('#password').keyup(function () {
       checkPassword()
    });

    $('#password').blur(function () {
        checkPassword()
    });

    function checkUserName() {
        if($('#username').val().length < 5){
            $('#error_username').html('username length < 5');
            $('#error_username').css('display', 'block');
            $('#sign_in').attr('disabled', 'disabled')
        }else{
            $('#error_username').html('&nbsp;');
        }
    }

    function checkPassword() {
        if($('#password').val().length < 6){
            $('#error_password').html('password length < 6');
            $('#error_password').css('display', 'block');
            $('#sign_in').attr('disabled', 'disabled')
        }else{
            $('#error_password').html('&nbsp;');
            $('#sign_in').removeAttr('disabled')
        }
    }
});