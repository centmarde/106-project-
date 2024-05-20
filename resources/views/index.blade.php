<!DOCTYPE html>
<html lang="{{ str_replace('_', '-', app()->getLocale()) }}">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Laravel</title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.bunny.net">
    <link href="https://fonts.bunny.net/css?family=figtree:400,600&display=swap" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="{{asset('css/app.css?v=').time()}}">
    <script src="https://unpkg.com/@dotlottie/player-component@latest/dist/dotlottie-player.mjs" type="module"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Styles -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>

<body class="antialiased" id="indexbody" style="height: 100vh;
    overflow: hidden;
    position: relative;">
    <div id="br" >
    <div class="container text-center"> 
    <script src="https://unpkg.com/@dotlottie/player-component@latest/dist/dotlottie-player.mjs" type="module"></script> 
    <div class="container d-flex justify-content-center">  <dotlottie-player id="logo"  src="https://lottie.host/0796593c-ce59-4b59-bd47-ebfa61c45b32/Jt0NpfBLcP.json" background="transparent" speed="1" style="width: 1000px; height: 500px;" loop autoplay></dotlottie-player></div>
  <div id="cont"  ><h1 style="font-family: 'Anton', sans-serif; font-size:50px;">Remote Method Invocation</h1>

    <span>Student Enrollment System</span>
                <a href="http://rmi2.test/landingPage" style="text-decoration: none;"><div class="d-flex justify-content-center mt-2"> <button class="btn">
    <span class="btn-text-one">Hover me</span>
    <span class="btn-text-two">Great!</span>
</button></div></a>
</div><div class="mt-5">
       
       <a id="ico1" style="text-decoration: none;" href="https://github.com/centmarde" target="blank">

             <i class="text-dark ms-2 mt-3 fa fa-github fa-2x" aria-hidden="true"></i>
         </a>
         <a id="ico2" style="text-decoration: none;" href="https://web.facebook.com/centmarde.campado/" target="blank">
             <i class="text-ligh ms-2 mt-3 fa fa-facebook fa-2x" aria-hidden="true"></i>
         </a>

        


     </div></div>
    
   
    <script src="{{ asset('js/app.js') }}"></script>
    <script>
        // Use jQuery to fade in the element with the specified id
        $(document).ready(function() {
            $("#title").fadeIn(); // Fade in the element with id "title"
        });
    </script>
</body>

</html>