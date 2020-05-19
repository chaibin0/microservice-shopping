package com.chaibin.shopping.config;

import org.springframework.restdocs.hypermedia.HypermediaDocumentation;
import org.springframework.restdocs.hypermedia.LinkDescriptor;
import org.springframework.restdocs.hypermedia.LinksSnippet;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;

public class RestDocsConfig {
    public static LinksSnippet links(LinkDescriptor... descriptors) {
        return HypermediaDocumentation.links(linkWithRel("self").ignored().optional());
    }
}
