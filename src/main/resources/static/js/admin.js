function loadTable(){
    console.log("test");
    $.ajax({
        type: 'GET',
        url: '/api/story',
        data: {
            format: 'json'
        },
        error: function() {
            var $error = $('<h1>').text('An error has occurred');
            $('#admin').append($error);
        },
        dataType: 'json',
        success: function(data) {
            $('#admin').empty();
            data.forEach(element => {
                var div = $('<div></div>').addClass('card');

                var autor = $('<div></div>').addClass('card-body').text(element.autor);
                var naslov = $('<div></div>').addClass('card-title').text(element.naslov);
                var sadrzaj = $('<p></p>').addClass('card-text').text(element.sadrzaj);
                var deleteDiv = $('<div></div>');
                var deleteButton = $("<button type='button' id= 'delBtn' class='btn btn-outline-danger' onclick ='showDeleteBookDialog("+element.id+")'>Delete</button>");
                deleteDiv.append(deleteButton);


                div.append(autor);
                div.append(naslov);
                div.append(sadrzaj);
                div.append(deleteDiv);


                $('#admin').append(div);
            });

        }
    });
}
function showDeleteBookDialog(id){
    $("#confimDeletion").modal("show");
    selectedStory = id;
}
function deleteStory(){
    console.log("fullStory : " + selectedStory);
    $.ajax({
        type: 'DELETE',
        url: '/api/story/'+selectedStory,
        error: function() {
            var $error = $('<h1>').text('An error has occurred');
            $('#admin').append($error);
        },
        success: function(data) {
            loadTable();
        }
    });
}
$(document).ready(function(){
     $("#header").load("components/header.html");
});
$(document).ready(function(){
    loadTable();
});