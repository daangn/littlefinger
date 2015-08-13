Parse.Cloud.afterSave("Message", function(request) {
  var config = require('cloud/config.js');
  var message = request.object;
  var body = JSON.stringify({
     channel: config.slack.channel,
     username: config.sender(message.get("sender")),
     text: message.get("body"),
     icon_emoji: config.slack.iconEmoji
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
