$(document).ready(()=> {
    
    // hover -> fadeTo
    $('#pdiv1').hide(0);
    $('#imgwrap1').hover(
        (event) => {
            $('#pdiv1').show(0);
            $('#preimg1').fadeTo(0, 0.4);
        },
        (event) => {
            $('#pdiv1').hide(0);
            $('#preimg1').fadeTo(0, 1);
        }
    );

    $('#pdiv2').hide(0);
    $('#imgwrap2').hover(
        (event) => {
            $('#pdiv2').show(0);
            $('#preimg2').fadeTo(0, 0.4);
        },
        (event) => {
            $('#pdiv2').hide(0);
            $('#preimg2').fadeTo(0, 1);
        }
    );

    $('#pdiv3').hide(0);
    $('#imgwrap3').hover(
        (event) => {
            $('#pdiv3').show(0);
            $('#preimg3').fadeTo(0, 0.4);
        },
        (event) => {
            $('#pdiv3').hide(0);
            $('#preimg3').fadeTo(0, 1);
        }
    );

});
