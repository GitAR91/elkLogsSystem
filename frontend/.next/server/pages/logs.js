"use strict";
/*
 * ATTENTION: An "eval-source-map" devtool has been used.
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file with attached SourceMaps in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
(() => {
var exports = {};
exports.id = "pages/logs";
exports.ids = ["pages/logs"];
exports.modules = {

/***/ "./pages/logs.js":
/*!***********************!*\
  !*** ./pages/logs.js ***!
  \***********************/
/***/ ((module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.a(module, async (__webpack_handle_async_dependencies__, __webpack_async_result__) => { try {\n__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   \"default\": () => (/* binding */ Logs)\n/* harmony export */ });\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react/jsx-dev-runtime */ \"react/jsx-dev-runtime\");\n/* harmony import */ var react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var axios__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! axios */ \"axios\");\nvar __webpack_async_dependencies__ = __webpack_handle_async_dependencies__([axios__WEBPACK_IMPORTED_MODULE_1__]);\naxios__WEBPACK_IMPORTED_MODULE_1__ = (__webpack_async_dependencies__.then ? (await __webpack_async_dependencies__)() : __webpack_async_dependencies__)[0];\n\n\nfunction Logs({ logs , error  }) {\n    if (error) {\n        return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"div\", {\n            children: [\n                \"An error occured: \",\n                error.message\n            ]\n        }, void 0, true, {\n            fileName: \"/home/artem/work/elkLogsSystem/frontend/pages/logs.js\",\n            lineNumber: 5,\n            columnNumber: 16\n        }, this);\n    }\n    return /*#__PURE__*/ (0,react_jsx_dev_runtime__WEBPACK_IMPORTED_MODULE_0__.jsxDEV)(\"p\", {\n        children: logs\n    }, void 0, false, {\n        fileName: \"/home/artem/work/elkLogsSystem/frontend/pages/logs.js\",\n        lineNumber: 8,\n        columnNumber: 9\n    }, this);\n}\n;\nLogs.getInitialProps = async (getLogs)=>{\n    try {\n        const log = await axios__WEBPACK_IMPORTED_MODULE_1__[\"default\"].get(\"http://localhost:8080/logs/test\");\n        const logs = log.data;\n        return {\n            logs\n        };\n    } catch (error) {\n        return {\n            error\n        };\n    }\n};\n\n__webpack_async_result__();\n} catch(e) { __webpack_async_result__(e); } });//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9wYWdlcy9sb2dzLmpzLmpzIiwibWFwcGluZ3MiOiI7Ozs7Ozs7Ozs7QUFBQTtBQUEwQjtBQUVYLFNBQVNDLEtBQUssRUFBQ0MsS0FBSSxFQUFFQyxNQUFLLEVBQUMsRUFBQztJQUN2QyxJQUFJQSxPQUFPO1FBQ1AscUJBQU8sOERBQUNDOztnQkFBSTtnQkFBbUJELE1BQU1FLE9BQU87Ozs7Ozs7SUFDaEQsQ0FBQztJQUNELHFCQUNJLDhEQUFDQztrQkFBR0o7Ozs7OztBQUVaLENBQUM7O0FBRURELEtBQUtNLGVBQWUsR0FBRyxPQUFNQyxVQUFXO0lBQ3BDLElBQUc7UUFDQyxNQUFNQyxNQUFNLE1BQU1ULGlEQUFTLENBQUM7UUFDNUIsTUFBTUUsT0FBT08sSUFBSUUsSUFBSTtRQUNyQixPQUFPO1lBQUVUO1FBQUs7SUFDbEIsRUFBRSxPQUFPQyxPQUFPO1FBQ1osT0FBTztZQUFFQTtRQUFNO0lBQ25CO0FBQ0oiLCJzb3VyY2VzIjpbIndlYnBhY2s6Ly9mcm9udGVuZC8uL3BhZ2VzL2xvZ3MuanM/Nzc4NSJdLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgYXhpb3MgZnJvbSBcImF4aW9zXCI7XG5cbmV4cG9ydCBkZWZhdWx0IGZ1bmN0aW9uIExvZ3Moe2xvZ3MsIGVycm9yfSl7XG4gICAgaWYgKGVycm9yKSB7XG4gICAgICAgIHJldHVybiA8ZGl2PkFuIGVycm9yIG9jY3VyZWQ6IHtlcnJvci5tZXNzYWdlfTwvZGl2PjtcbiAgICB9XG4gICAgcmV0dXJuIChcbiAgICAgICAgPHA+e2xvZ3N9PC9wPlxuICAgICk7XG59O1xuXG5Mb2dzLmdldEluaXRpYWxQcm9wcyA9IGFzeW5jIGdldExvZ3MgPT4ge1xuICAgIHRyeXtcbiAgICAgICAgY29uc3QgbG9nID0gYXdhaXQgYXhpb3MuZ2V0KCdodHRwOi8vbG9jYWxob3N0OjgwODAvbG9ncy90ZXN0Jyk7XG4gICAgICAgIGNvbnN0IGxvZ3MgPSBsb2cuZGF0YTtcbiAgICAgICAgcmV0dXJuIHsgbG9ncyB9XG4gICAgfSBjYXRjaCAoZXJyb3IpIHtcbiAgICAgICAgcmV0dXJuIHsgZXJyb3IgfTtcbiAgICB9XG59Il0sIm5hbWVzIjpbImF4aW9zIiwiTG9ncyIsImxvZ3MiLCJlcnJvciIsImRpdiIsIm1lc3NhZ2UiLCJwIiwiZ2V0SW5pdGlhbFByb3BzIiwiZ2V0TG9ncyIsImxvZyIsImdldCIsImRhdGEiXSwic291cmNlUm9vdCI6IiJ9\n//# sourceURL=webpack-internal:///./pages/logs.js\n");

/***/ }),

/***/ "react/jsx-dev-runtime":
/*!****************************************!*\
  !*** external "react/jsx-dev-runtime" ***!
  \****************************************/
/***/ ((module) => {

module.exports = require("react/jsx-dev-runtime");

/***/ }),

/***/ "axios":
/*!************************!*\
  !*** external "axios" ***!
  \************************/
/***/ ((module) => {

module.exports = import("axios");;

/***/ })

};
;

// load runtime
var __webpack_require__ = require("../webpack-runtime.js");
__webpack_require__.C(exports);
var __webpack_exec__ = (moduleId) => (__webpack_require__(__webpack_require__.s = moduleId))
var __webpack_exports__ = (__webpack_exec__("./pages/logs.js"));
module.exports = __webpack_exports__;

})();