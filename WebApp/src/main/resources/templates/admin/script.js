$(document).ready(function() {
    $.getJSON('http://localhost:8078/user/users', function(json) {
        var tr=[];
        for (var i = 0; i < json.length; i++) {
            tr.push('<tr>');
            tr.push('<td>' + json[i].id + '</td>');
            tr.push('<td>' + json[i].user + '</td>');
            tr.push('<td>' + json[i].fullName + '</td>');
            tr.push('<td>' + json[i].email + '</td>');
            tr.push('<td>' + json[i].phone + '</td>');
            tr.push('<td>' + json[i].address + '</td>');
            tr.push('<td><button class=\'edit\'>Edit</button>&nbsp;&nbsp;<button class=\'delete\' id=' + json[i].id + '>Delete</button></td>');
            tr.push('</tr>');
        }
        $('table').append($(tr.join('')));
    });

    $(document).delegate('#addNewUser', 'click', function(event) {
        event.preventDefault();

        var user = $('#user').val();

        $.ajax({
            url: "http://localhost:8078/user/signup",
            type: "POST",
            data: JSON.stringify({'user': user}),
            datatype: "json",
            success: function(result) {
                $("#msg").html( "<span style='color: green'>Company added successfully</span>" );
                window.setTimeout(function(){location.reload()},1000)
            },
            error: function(err) {
                $("#msg").html( "<span style='color: red'>User is required</span>" );
            }
        });

    });

    $(document).delegate('.delete', 'click', function() {
        if (confirm('Do you really want to delete record?')) {
            var id = $(this).attr('id');
            var parent = $(this).parent().parent();
            $.ajax({
                type: "GET",
                url: "http://localhost:8078/user/delete/" + id,
                cache: false,
                success: function() {
                    parent.fadeOut('slow', function() {
                        $(this).remove();
                    });
                    location.reload(true)
                },
                error: function() {
                    $('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error deleting record').fadeIn().fadeOut(4000, function() {
                        $(this).remove();
                    });
                }
            });
        }
    });

    $(document).delegate('.edit', 'click', function() {
        var parent = $(this).parent().parent();

        var id = parent.children("td:nth-child(1)");
        var user = parent.children("td:nth-child(2)");
        var fullName = parent.children("td:nth-child(3)");
        var email = parent.children("td:nth-child(4)");
        var phone = parent.children("td:nth-child(5)");
        var address = parent.children("td:nth-child(6)");
        //Buttons Sava
        var buttons = parent.children("td:nth-child(7)");

        user.html("<input type='text' id='txtUser' value='" + user.html() + "'/>");
        fullName.html("<input type='text' id='txtfullName' value='" + fullName.html() + "'/>");
        email.html("<input type='text' id='txtEmail' value='" + email.html() + "'/>");
        phone.html("<input type='text' id='txtEmail' value='" + phone.html() + "'/>");
        address.html("<input type='text' id='txtEmail' value='" + address.html() + "'/>");

        buttons.html("<button id='save'>Save</button>");
        //;<button class='delete' id='" + id.html() + "'>Delete</button>");
    });

    $(document).delegate('#save', 'click', function() {
        var parent = $(this).parent().parent();

        var id = parent.children("td:nth-child(1)");
        var name = parent.children("td:nth-child(2)");
        var buttons = parent.children("td:nth-child(3)");

        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            url: "http://localhost:8080/company/save",
            data: JSON.stringify({'id' : id.html(), 'name' : name.children("input[type=text]").val()}),
            cache: false,
            success: function() {
                name.html(name.children("input[type=text]").val());
                buttons.html("<button class='edit' id='" + id.html() + "'>Edit</button>&nbsp;&nbsp;<button class='delete' id='" + id.html() + "'>Delete</button>");
            },
            error: function() {
                $('#err').html('<span style=\'color:red; font-weight: bold; font-size: 30px;\'>Error updating record').fadeIn().fadeOut(4000, function() {
                    $(this).remove();
                });
            }
        });
    });
});