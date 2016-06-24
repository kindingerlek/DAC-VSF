$(document).ready(function () {
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue'
    });

    $("input[name=personType]:radio").on('ifChecked', changePerson);
});

function changePerson() {
    if (this.value === '1') {
        $('#person-section').show();
        $('#enterprise-section').hide();
        $('.submit-button').removeAttr('disabled');
        $('.error-person').html('');
    } else {
        $('#person-section').hide();
        $('#enterprise-section').show();
        $('.submit-button').removeAttr('disabled');
        $('.error-person').html('');
    }
}