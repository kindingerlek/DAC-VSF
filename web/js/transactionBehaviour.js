$(document).ready(function () {
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue'
    });

    $("input[name=destinationType]:radio").on('ifChecked', changePerson);
    changePerson();
});

function changePerson() {
    if (this.value === '1') {
        $("#myAccounts :input").prop("disabled", false);
        $("#otherAccounts :input").prop("disabled", true);

    } else {
        $("#myAccounts :input").prop("disabled", true);
        $("#otherAccounts :input").prop("disabled", false);
    }
}