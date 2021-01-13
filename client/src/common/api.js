import axios from "axios";

export function get(path = '') {
    return axios.get(path).catch(err => {
        console.log(err);
        throw Error('Http Get Error: api');
    })

}

export function post(path = '', params) {
    return axios.post(path, params).catch(err => {
        console.log(err);
        throw Error('Http Post Error: api');
    })

}