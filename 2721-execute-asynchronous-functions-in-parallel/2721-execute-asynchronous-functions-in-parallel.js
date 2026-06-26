/**
 * @param {Array<Function>} functions
 * @return {Promise<any[]>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        let res = new Array(functions.length);
        let count = 0;

        functions.forEach((fn, i) => {
            fn()
                .then(val => {
                    res[i] = val;
                    count++;
                    if (count === functions.length) resolve(res);
                })
                .catch(reject);
        });
    });
};