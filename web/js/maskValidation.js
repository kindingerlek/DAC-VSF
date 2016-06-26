$('.cpf').mask('999.999.999-99');
$('.cnpj').mask('99.999.999/9999-99');
$('.phone').mask('(99) 9999-9999');
$('.agency').mask('99999');
$('.account').mask('99999-9');

$('.money').on('blur', function () {
    var value = $('.money').val();
    if (value) {
        if (!value.match(/R\$/gi)) {
            $('.money').val('R$ ' + value);
            value = $('.money').val();
        }
        if (!value.match(','))
            $('.money').val(value + ',00');
    }
});

function formatCurrency() {
    $('.money').val($('.money').val().slice(2, -3));
}