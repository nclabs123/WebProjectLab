$(function() {
    $("#btn").click(function() {

        var testdata = JSON.stringify({
            "id":"0",
            "name": $('#hero_name').val(),
           "universe": $('#hero_universe').val(),
            "power": $('#hero_power').val(),
            "description": $('#hero_description').val(),
            "alive": $('#hero_alive').val()

        });

        $.ajax({
            type: "PUT",
            url:"/MainServlet",
            data: testdata,
            dataType: "json",
            contentType: "application/json",
        });

        });
    });



