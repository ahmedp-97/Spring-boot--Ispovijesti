 $(document).ready(function(){
        $("#add-story-button").click(function(){
            var story = {
                        autor: $("#autor").val(),
                        naslov: $("#naslov").val(),
                        sadrzaj: $("#sadrzaj").val()};
            $.ajax({
                type: 'POST',
                url: '/api/story',
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                data: JSON.stringify(story),
                error: function() {
                    var $error = $('<h1>').text('An error has occurred');
                    $('body').append($error);
                },
                success: function(data) {
                    console.log("added story");
                    $("#autor").val("");
                    $("#naslov").val("");
                    $('#sadrzaj').val("");
                    loadTable();
                }
            });
        });
    });