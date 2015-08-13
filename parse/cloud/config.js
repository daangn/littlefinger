exports.slack = {
  hookUrl: "https://hooks.slack.com/services/xxx/yyy",
  channel: "#card",
  iconEmoji: ":moneybag:"
}

exports.sender = function(phoneNumber) {
  var phoneDic = {
    "15447200": "신한카드"
  };
  return phoneDic[phoneNumber] || phoneNumber;
}
