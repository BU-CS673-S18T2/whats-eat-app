$(document).ready(function(){
    $(".signupbtn").click(function(){
        var $username = $('[name="username"]');
        var $email = $('[name="email"]');
        var $password = $('[name="password"]');
        var $gender = $('[name="gender"]');
        var $height = $('[name="height"]');
        var $weight = $('[name="weight"]');
        var $age = $('[name="age"]');
        console.log($username);

        var user = {
            username: $username.val(),
            email: $email.val(),
            password: $password.val(),
            gender: $gender.val(),
            height: $height.val(),
            weight: $weight.val(),
            age: $age.val()
        };

        $.ajax({
            type: 'POST',
            url: 'api/main/signup',
            data: user,
            success: function(newUser){
                console.log(newUser);
                $("#id01").style.display = 'none';

            },
            error: function () {
              alert("error");
            }
        })
    })
});

