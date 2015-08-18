Parse.Cloud.afterSave("Message", function(request) {
  var config = require('cloud/config.js');
  var message = request.object;
  var sender = config.sender(message.get("sender"))

  var body = JSON.stringify({
     channel: sender.channel,
     username: sender.name,
     text: message.get("body"),
     icon_emoji: sender.emoji
  });
  Parse.Cloud.httpRequest({
    method: "POST",
    headers: {
      'Content-Type': 'application/json;charset=utf-8'
    },
    url: config.slack.hookUrl,
    body: body
  }).then(function(httpResponse) {
  }, function(httpResponse) {
    console.error('Request failed with response code : ' + httpResponse.status + httpResponse.text);
  });
});
