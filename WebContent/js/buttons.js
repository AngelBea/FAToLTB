/**
 *
 */

$(document).ready(function () {
    $("#usercode").popover({
        placement: 'right',
        container: 'body',
        html: true,
        trigger: 'hover',
        title: 'How to',
        content: '<img class="img-popup" src="img/FAUserCode.gif"></img>'
    });
    $('#checkbox1').prop('checked', true);
})

$("input[name='check']").change(function () {

    if ($('#checkbox1').is(":checked")) {
        $('.toggle').show();
        $('.toggle-passive').removeClass("col-md-6").addClass("col-md-3");
        $('.toggle-passive').removeClass("col-lg-6").addClass("col-lg-3");
    } else if ($('#checkbox2').is(":checked")) {
        $('.toggle').hide();
        $('.toggle-passive').removeClass("col-lg-3").addClass("col-lg-6");
        $('.toggle-passive').removeClass("col-md-3").addClass("col-md-6");

    }
});

$("#convert").on("click", function () {
    if ($('#checkbox1').is(":checked")) {
        $.ajax({
            url: "Convert/email",
            type: "post",
            data: {
                usercode: $("#usercode").val(),
                email: $("#email").val()
            },
            success: function () {
                console.log("datos enviados");
            }
        })
    } else if ($('#checkbox2').is(":checked")) {
        $.ajax({
            url: "Convert/noemail",
            type: "post",
            data: {
                usercode: $("#usercode").val()
            },
            success: function () {
                console.log("datos enviados");
            }
        })
    }


})
