"use strict";

var Mustache = require("mustache");
var fs = require("fs");

var path = require("path");

var view = {
	version: require(path.resolve(__dirname, "../package.json")).version,
	mainlogo: fs.readFileSync(path.resolve(__dirname, "docxtemplater.svg")).toString(),
	features: {
		easy: fs.readFileSync(path.resolve(__dirname, "basic14.svg")).toString(),
		everywhere: fs.readFileSync(path.resolve(__dirname, "cellphone106.svg")).toString(),
		fulldocumentation: fs.readFileSync(path.resolve(__dirname, "text150.svg")).toString(),
		manytags: fs.readFileSync(path.resolve(__dirname, "open112.svg")).toString(),
		openextension: fs.readFileSync(path.resolve(__dirname, "puzzle37.svg")).toString(),
		freebeer: fs.readFileSync(path.resolve(__dirname, "drink24.svg")).toString(),
		fullytested: fs.readFileSync(path.resolve(__dirname, "test-tube12.svg")).toString(),
	},
};

var baseHtml = fs.readFileSync(path.resolve(__dirname, "index.mustache")).toString();

var output = Mustache.render(baseHtml, view);

fs.writeFileSync(path.resolve(__dirname, "index.html"), output);
