function GetRequest(url, param) {
    return new Promise(function (resolve, reject) {
        return axios.get(url, {
            params: param ? param : {}
        })
            .then((data) => {
                return resolve(data.data);
            })
            .catch((err) => {
                return reject(err);
            });
    });
}

function PostRequest(url, param) {
    return new Promise(function (resolve, reject) {
        return axios.post(url, {
            params: param ? param : {}
        })
            .then((data) => {
                return resolve(data);
            })
            .catch((err) => {
                return reject(err);
            });
    });
}


function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    } else {
        return null;
    }
}