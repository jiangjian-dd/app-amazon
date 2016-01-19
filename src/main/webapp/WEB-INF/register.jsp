<html>
<head>
  <title>User Register</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
</head>

<body>
<div class="container">
  <form role="form" data-toggle="validator" class="form-horizontal" action='register' method="POST">
    <fieldset>
      <div id="legend">
        <legend class="">Register</legend>
      </div>

      <div class="control-group">
          <% String redirectUrl = request.getParameter("redirectUrl");%>
          <input type="hidden" id="amazon-redirect-url" name="amazon-redirect-url" value="<%=redirectUrl%>">
      </div>

      <div class="control-group">
        <label class="control-label"  for="username">Username</label>
        <div class="controls">
          <input type="text" id="username" name="username" placeholder="" class="form-control" pattern="^[A-z0-9]{1,}$" required>
          <p class="help-block">Username can contain any letters or numbers, without spaces</p>
        </div>
      </div>

      <div class="control-group">
        <label class="control-label" for="email">E-mail</label>
        <div class="controls">
          <input type="email" id="email" name="email" placeholder="" class="form-control" required>
          <p class="help-block">Please provide your E-mail</p>
        </div>
      </div>

      <div class="control-group">
        <label class="control-label" for="password">Password</label>
        <div class="controls">
          <input type="password" id="password" name="password" minlength="4" placeholder="" class="form-control" required>
          <p class="help-block">Password should be at least 4 characters</p>
        </div>
      </div>

      <div class="control-group">
        <label class="control-label"  for="password_confirm">Password (Confirm)</label>
        <div class="controls">
          <input type="password" id="password_confirm" data-match="#password" data-match-error="password not match"  name="password_confirm" placeholder="" class="form-control" required>
          <p class="help-block">Please confirm password</p>
        </div>
      </div>

      <div class="control-group">
        <div class="controls">
          <button class="btn btn-success" type="submit">Register</button>
        </div>
      </div>

    </fieldset>
  </form>
</div>
</body>
</html>
