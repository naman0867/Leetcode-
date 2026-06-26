/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (obj === null || typeof obj !== "object") return obj;

    if (Array.isArray(obj)) {
        return obj
            .filter(Boolean)
            .map(compactObject);
    }

    const res = {};
    for (const key in obj) {
        const val = compactObject(obj[key]);
        if (Boolean(val)) res[key] = val;
    }
    return res;
};