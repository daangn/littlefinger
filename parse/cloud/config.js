exports.slack = {
  hookUrl: "https://hooks.slack.com/services/xxx/yyy"
}

exports.sender = function(phoneNumber) {
  var phoneDic = {
    "15447200": {
      name: '신한카드',
      channel: '#card',
      emoji: ':moneybag:'
    }
  };
  var defaultItem = {
      name: phoneNumber,
      channel: '#sms',
      emoji: ':ghost:'
    }
  return phoneDic[phoneNumber] || defaultItem;
}
