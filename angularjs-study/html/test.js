function runnian() {
  var na = document.getElementById('na').value;
  var nb = document.getElementById('nb').value;
  var nc;
  var demoDiv = document.getElementById('demo-div');
  if (na == nb || isNaN(na) || isNaN(nb)) {
    demoDiv.innerHTML = '输入有误';
    return;
  }
  na = parseInt(na);
  nb = parseInt(nb);
  if (na > nb) {
    nc = na;
    na = nb;
    nb = nc;
  }
  //innerHTML是读写元素里面的内容
  demoDiv.innerHTML = '';
  for (var i = na; i <= nb; i++) {
    if ((i % 4 == 0 && i % 100 != 0) || i % 4 == 0) {
      demoDiv.innerHTML = demoDiv.innerHTML + i + '是闰年<br/>';
    }
  }
}

function wanshu() {
  var na = document.getElementById('na').value;
  var nb = document.getElementById('nb').value;
  var nc;
  if (isNaN(na) || isNaN(nb)) {
    demoDiv.innerHTML = '输入有误';
    return;
  }
  na = parseInt(na);
  nb = parseInt(nb);
  if (na > nb) {
    nc = na;
    na = nb;
    nb = nc;
  }
  var demoDiv = document.getElementById('demo-div');
  demoDiv.innerHTML = '';
  for (var i = na; i <= nb; i++) { 
    if (yinshuhe(i) == i) {
      demoDiv.innerHTML = demoDiv.innerHTML + i + '是完数<br/>';
    }
  }
}

function yinshuhe(a) {
  //求因数（能整除的数）和
  var sum = 0;
  for (var i = 1; i < a; i++) {
    if (a % i == 0) {
      sum += i;
    }
  }
  return sum;
}
