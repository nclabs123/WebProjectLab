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

        console.log(testdata);
        $.ajax({
            type: "POST",
            url:"/MainServlet",
            data: testdata,
            dataType: "json",
            contentType: "application/json",

            success:function(AddData)//Если запрос удачен
            {
                $("#hero_place").empty();
                var i;
                for(i=0; i<AddData.length; i++){
                    $('#hero_place').append(
                        "<div class = hero_block>"
                        +"<h1>"+"№"+AddData[i].id+"</h1>"
                        +"<p>"+AddData[i].name+"</p>"
                        +"<p>"+AddData[i].universe+"</p>"
                        +"<p>"+AddData[i].power+"</p>"
                        +"<p>"+AddData[i].description+"</p>"
                        +"<p>"+AddData[i].alive+"</p>"
                        +"<div>"+"<input type='button' class='update' value='Update Hero_"+AddData[i].id+"' onclick='return updatehero(this.value)'/>"+"</div>"
                        +"<div>"+"<input type='button' class='delete' value='Delete Hero_"+AddData[i].id+"' onclick='return deletehero(this.value)'/>"+"</div>"+
                        "</div>"

                    )


                }

                console.log(AddData);
            },
            error: function(e)//Если запрос не удачен
            {
                $("#hero_place").html("Запрос не удался!");
                console.log(e);
            }

        });
    });


});


function deletehero(id) {
    console.log(id);
        $.ajax({
            type: "DELETE",
            url: "/MainServlet",
            data: id,
            dataType: "json",
            contentType: "application/json",

            success: function (DeleteData)//Если запрос удачен
            {
                $("#hero_place").empty();
                var i;
                for(i=0; i<DeleteData.length; i++){
                    $('#hero_place').append(
                        "<div class = hero_block>"
                        +"<h1>"+"№"+DeleteData[i].id+"</h1>"
                        +"<p>"+DeleteData[i].name+"</p>"
                        +"<p>"+DeleteData[i].universe+"</p>"
                        +"<p>"+DeleteData[i].power+"</p>"
                        +"<p>"+DeleteData[i].description+"</p>"
                        +"<p>"+DeleteData[i].alive+"</p>"
                        +"<div>"+"<input type='button' class='update' value='Update Hero_"+DeleteData[i].id+"' onclick='return updatehero(this.value)'/>"+"</div>"
                        +"<div>"+"<input type='button' class='delete' value='Delete Hero_"+DeleteData[i].id+"' onclick='return deletehero(this.value)'/>"+"</div>"+
                        "</div>"

                    )


                }

                console.log(DeleteData);
            },
            error: function (e)//Если запрос не удачен
            {
                $("#hero_place").html("Запрос не удался!");
                console.log(e);
            }

        });
}



function updatehero(id) {
    console.log(id);
    $(document).ready(function() { // вся мaгия пoсле зaгрузки стрaницы
        $('.update').click( function(event){ // лoвим клик пo ссылки с id="go"
            event.preventDefault(); // выключaем стaндaртную рoль элементa
            $('#overlay').fadeIn(400, // снaчaлa плaвнo пoкaзывaем темную пoдлoжку
                function(){ // пoсле выпoлнения предъидущей aнимaции
                    $('#modal_form')
                        .css('display', 'block') // убирaем у мoдaльнoгo oкнa display: none;
                        .animate({opacity: 1, top: '50%'}, 200); // плaвнo прибaвляем прoзрaчнoсть oднoвременнo сo съезжaнием вниз
                });
        });
        /* Зaкрытие мoдaльнoгo oкнa, тут делaем тo же сaмoе нo в oбрaтнoм пoрядке */
        $('#modal_close, #overlay').click( function(){ // лoвим клик пo крестику или пoдлoжке
            $('#modal_form')
                .animate({opacity: 0, top: '45%'}, 200,  // плaвнo меняем прoзрaчнoсть нa 0 и oднoвременнo двигaем oкнo вверх
                    function(){ // пoсле aнимaции
                        $(this).css('display', 'none'); // делaем ему display: none;
                        $('#overlay').fadeOut(400); // скрывaем пoдлoжку
                    }
                );
        });
    });


    $("#update_btn").click(function() {

        var idArray = id.split("_");

        var updatedata = JSON.stringify({
            "id":idArray[1],
            "name": $('#update_hero_name').val(),
            "universe": $('#update_hero_universe').val(),
            "power": $('#update_hero_power').val(),
            "description": $('#update_hero_description').val(),
            "alive": $('#update_hero_alive').val()

        });

        console.log(updatedata);
        $.ajax({
            type: "PUT",
            url:"/MainServlet",
            data: updatedata,
            dataType: "json",
            contentType: "application/json",

            success:function(UpdateData)//Если запрос удачен
            {
                $("#hero_place").empty();
                var i;
                for(i=0; i<UpdateData.length; i++){
                    $('#hero_place').append(
                        "<div class = hero_block>"
                        +"<h1>"+"№"+UpdateData[i].id+"</h1>"
                        +"<p>"+UpdateData[i].name+"</p>"
                        +"<p>"+UpdateData[i].universe+"</p>"
                        +"<p>"+UpdateData[i].power+"</p>"
                        +"<p>"+UpdateData[i].description+"</p>"
                        +"<p>"+UpdateData[i].alive+"</p>"
                        +"<div>"+"<input type='button' class='update' value='Update Hero_"+UpdateData[i].id+"' onclick='return updatehero(this.value)'/>"+"</div>"
                        +"<div>"+"<input type='button' class='delete' value='Delete Hero_"+UpdateData[i].id+"' onclick='return deletehero(this.value)'/>"+"</div>"+
                        "</div>"

                    )


                }

                console.log(UpdateData);
            },
            error: function(e)//Если запрос не удачен
            {
                $("#hero_place").html("Запрос не удался!");
                console.log(e);
            }

        });
    });



    /*$('#boxes').append(
        "<div id='window_update' class='update_window'>"
        +"<div class='update_top'>"+"<a href = '#' class = 'link close'>Modal window text</a></div>"
        +"<div class = 'update_content'>Text in mod window</div>"+
        "</div>"
    )*/

    /*$.ajax({
        type: "DELETE",
        url: "/MainServlet",
        data: id,
        dataType: "json",
        contentType: "application/json",

        success: function (UpdateData)//Если запрос удачен
        {
            $("#hero_place").empty();
            var i;
            for(i=0; i<UpdateDate.length; i++){
                $('#hero_place').append(
                    "<div class = hero_block>"
                    +"<h1>"+"№"+UpdateData[i].id+"</h1>"
                    +"<p>"+UpdateData[i].name+"</p>"
                    +"<p>"+UpdateData[i].universe+"</p>"
                    +"<p>"+UpdateData[i].power+"</p>"
                    +"<p>"+UpdateData[i].description+"</p>"
                    +"<p>"+UpdateData[i].alive+"</p>"
                    +"<div>"+"<input type='button' class='update' value='Update Hero_"+UpdateData[i].id+"' onclick='return updatehero(this.value)'/>"+"</div>"
                    +"<div>"+"<input type='button' class='delete' value='Delete Hero_"+UpdateData[i].id+"' onclick='return deletehero(this.value)'/>"+"</div>"+
                    "</div>"

                )


            }

            console.log(DeleteData);
        },
        error: function (e)//Если запрос не удачен
        {
            $("#hero_place").html("Запрос не удался!");
            console.log(e);
        }

    });*/
}