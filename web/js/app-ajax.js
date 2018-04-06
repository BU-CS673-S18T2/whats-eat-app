$(document).ready(function(){
    $(".signupbtn").click(function(){
        var $username = $('[name="username"]');
        var $email = $('[name="email"]');
        var $password = $('[name="password"]');
        var $gender = $('[name="gender"]');
        var $height = $('[name="height"]');
        var $weight = $('[name="weight"]');
        var $age = $('[name="age"]');

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
                $("#signupform")[0].reset();
                $("#id01").hide();
                $("#signup").hide();
                $("#login").hide();
                var welcome = "Welcome, " + newUser.username + "!";
                console.log(welcome);
                $("#welcome")[0].innerHTML = welcome;



                // window.location.href = '';
            },
            error: function () {
              alert("error");
            }
        })
    });

    $(".loginbtn").click(function(){
        var $username = $('[name="loginname"]');
        var $password = $('[name="loginpassword"]');
        console.log($username.val(),$password.val());

        var user = {
            username: $username.val(),
            password: $password.val()
        };

        $.ajax({
            type: 'POST',
            url: 'api/main/signin',
            data: user,
            success: function(newUser){
                console.log(newUser);
                $("#loginform")[0].reset();
                $("#id02").hide();
                $("#signup").hide();
                $("#login").hide();
                var welcome = "Welcome, " + newUser.username + "!";
                console.log(welcome);
                $("#welcome")[0].innerHTML = welcome;

            },
            error: function () {
                alert("error");
            }
        })
    });
    var foods;
    $(".Button").click(function(){

        if(foods){
            var rdn = Math.floor((Math.random() * 27368) + 1);
            var html = foods[rdn].name+
                ", Calories: "+"\n" + foods[rdn].calorie + "Cal" ;
            document.getElementById("demo").innerHTML = html;
        } else{
            $.ajax({
                type: 'GET',
                url: 'api/main/foodlist',
                success: function (foodlist) {
                    foods = foodlist;
                    var rdn = Math.floor((Math.random() * 27368) + 1);
                    var html = foods[rdn].name+
                        ", Calories: "+ foods[rdn].calorie;
                    document.getElementById("demo").innerHTML = html;
                }
            })
        }

    });
});

