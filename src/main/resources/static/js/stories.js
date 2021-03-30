var n =  new Date();
var y = n.getFullYear();
var m = n.getMonth() + 1;
var d = n.getDate();
document.getElementById("date").innerHTML = d + "/" + m + "/" + y;

function loadTable(){
    $.ajax({
        type: 'GET',
        url: '/api/story',
        data: {
            format: 'json'
        },
        error: function() {
            var $error = $('<h1>').text('An error has occurred');
            $('#stories').append($error);
        },
        dataType: 'json',
        success: function(data) {
            $('#stories').empty();
            data.forEach(element => {
                var div = $('<div></div>').addClass('card');
                var autor = $('<div></div>').addClass('card-body').text(element.autor);
                var naslov = $('<div></div>').addClass('card-title').text(element.naslov);
                var sadrzaj = $('<div></div>').addClass('card-text').text(element.sadrzaj);
                var readMoreButton = $("<button type='button' id='btnLink' class='btn btn-link' onclick ='getStory("+element.id+")'>Pročitaj više</button>");

                div.append(div);
                div.append(autor);
                div.append(naslov);
                div.append(sadrzaj);
                div.append(readMoreButton);


                $('#stories').append(div);
            });

        }
    });
}

function getStory(id){
    selectedStory = id;
    console.log("getStory : " + id);
    $.ajax({
        type: 'GET',
        url: '/api/story/ '+ id,
        error: function() {
            var $error = $('<h1>').text('An error has occurred');
            $('#stories').append($error);
        },
        success: function(data) {
        console.log("test")
            $('#story-title').text(data.naslov)
            $('#story-autor').text(data.autor)
            $('#story-sadrzaj').text(data.sadrzaj)
            $('#like-story').data('story-id', data.id)
            $('#dislike-story').data('story-id', data.id)
            $('#like-count').text(data.odobravam)
            $('#dislike-count').text(data.osudjujem)
            $('#myModal').modal('show')

        }
    });
}

function odobravam(){
    var id = $("#like-story").data("story-id");
    console.log("putOdobravam : " + id);
    $.ajax({
        type: 'PUT',
        url: '/api/story/odobravam/'+ id,
        error: function() {
            var $error = $('<h1>').text('An error has occurred');
            $('#stories').append($error);
        },
        success: function(data) {
            $("#like-count").text(data.odobravam);
        }
    });
}
function osudjujem(id){
     var id = $("#dislike-story").data("story-id");
        console.log("putOsudjujeam : " + id);
        $.ajax({
            type: 'PUT',
            url: '/api/story/osudjujem/'+ id,
            error: function() {
                var $error = $('<h1>').text('An error has occurred');
                $('#stories').append($error);
            },
            success: function(data) {
                $("#dislike-count").text(data.osudjujem);
            }
        });
    }
$(document).ready(function(){
     $("#header").load("components/header.html");
});
$(document).ready(function(){
    loadTable();
});