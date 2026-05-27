import {test} from '@playwright/test';
import {GalleryPage} from '../../pages/GalleryPage';
import {mockImages} from '../../fixtures/mockData';

test('Verify image gallery loads successfully', async ({page}) => {

    const galleryPage = new GalleryPage(page);

    await page.route('**/api/images', async route => {

        await route.fulfill({
            status: 200,
            contentType: 'application/json',
            body: JSON.stringify(mockImages)
        });
    });

    await galleryPage.launchApplication();

    await galleryPage.verifyImageVisible('Nature');

    await galleryPage.verifyImageVisible('Beach');

});
