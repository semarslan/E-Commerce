import {get} from "@/common/api";


export function getById(id) {
    return get('products/'+id);
}

export function getAll() {
    return get('products/');
}
