/* eslint-disable import/first */
import '../coresrc/polyfill';
import { jsdom } from 'jsdom';
import Enzyme from 'enzyme';
import Adapter from 'enzyme-adapter-react-16';

Enzyme.configure({ adapter: new Adapter() });

// fixed jsdom miss
const documentHTML = '<!doctype html><html><body><div id="root"></div></body></html>';
global.document = jsdom(documentHTML);
global.window = document.defaultView;
global.navigator = global.window.navigator;
