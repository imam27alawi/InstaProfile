package com.alawiyaa.instagramprofile.data.remote.response

import com.google.gson.annotations.SerializedName

data class Responsew(

	@field:SerializedName("logging_page_id")
	val loggingPageId: String? = null,

	@field:SerializedName("toast_content_on_load")
	val toastContentOnLoad: Any? = null,

	@field:SerializedName("show_suggested_profiles")
	val showSuggestedProfiles: Boolean? = null,

	@field:SerializedName("graphql")
	val graphql: Graphql? = null,

	@field:SerializedName("show_follow_dialog")
	val showFollowDialog: Boolean? = null,

	@field:SerializedName("show_view_shop")
	val showViewShop: Boolean? = null
)

data class Dimensions(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class EdgeSavedMedia(

	@field:SerializedName("page_info")
	val pageInfo: PageInfo? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("edges")
	val edges: ArrayList<Any>? = null
)

data class ThumbnailResourcesItem(

	@field:SerializedName("src")
	val src: String? = null,

	@field:SerializedName("config_height")
	val configHeight: Int? = null,

	@field:SerializedName("config_width")
	val configWidth: Int? = null
)

data class EdgeMediaToComment(

	@field:SerializedName("count")
	val count: Int? = null
)

data class Location(

	@field:SerializedName("has_public_page")
	val hasPublicPage: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class EdgeMediaToCaption(

	@field:SerializedName("edges")
	val edges: ArrayList<EdgesItem>? = null
)

data class EdgeFelixVideoTimeline(

	@field:SerializedName("page_info")
	val pageInfo: PageInfo? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("edges")
	val edges: List<Any>? = null
)

data class EdgeMediaPreviewLike(

	@field:SerializedName("count")
	val count: Int? = null
)

data class EdgeOwnerToTimelineMedia(

	@field:SerializedName("page_info")
	val pageInfo: PageInfo? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("edges")
	val edges: ArrayList<EdgesItem>? = null
)

data class EdgeMediaCollections(

	@field:SerializedName("page_info")
	val pageInfo: PageInfo? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("edges")
	val edges: ArrayList<Any>? = null
)

data class Node(

	@field:SerializedName("owner")
	val owner: Owner? = null,

	@field:SerializedName("display_url")
	val displayUrl: String? = null,

	@field:SerializedName("edge_media_to_comment")
	val edgeMediaToComment: EdgeMediaToComment? = null,

	@field:SerializedName("thumbnail_src")
	val thumbnailSrc: String? = null,

	@field:SerializedName("taken_at_timestamp")
	val takenAtTimestamp: Int? = null,

	@field:SerializedName("accessibility_caption")
	val accessibilityCaption: String? = null,

	@field:SerializedName("__typename")
	val typename: String? = null,

	@field:SerializedName("edge_media_to_tagged_user")
	val edgeMediaToTaggedUser: EdgeMediaToTaggedUser? = null,

	@field:SerializedName("shortcode")
	val shortcode: String? = null,

	@field:SerializedName("media_overlay_info")
	val mediaOverlayInfo: Any? = null,

	@field:SerializedName("edge_liked_by")
	val edgeLikedBy: EdgeLikedBy? = null,

	@field:SerializedName("is_video")
	val isVideo: Boolean? = null,

	@field:SerializedName("media_preview")
	val mediaPreview: String? = null,

	@field:SerializedName("gating_info")
	val gatingInfo: Any? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("fact_check_information")
	val factCheckInformation: Any? = null,

	@field:SerializedName("comments_disabled")
	val commentsDisabled: Boolean? = null,

	@field:SerializedName("fact_check_overall_rating")
	val factCheckOverallRating: Any? = null,

	@field:SerializedName("edge_media_to_caption")
	val edgeMediaToCaption: EdgeMediaToCaption? = null,

	@field:SerializedName("thumbnail_resources")
	val thumbnailResources: List<ThumbnailResourcesItem?>? = null,

	@field:SerializedName("dimensions")
	val dimensions: Dimensions? = null,

	@field:SerializedName("edge_media_preview_like")
	val edgeMediaPreviewLike: EdgeMediaPreviewLike? = null,

	@field:SerializedName("text")
	val text: String? = null
)

data class EdgeFollow(

	@field:SerializedName("count")
	val count: Int? = null
)

data class EdgeMediaToTaggedUser(

	@field:SerializedName("edges")
	val edges: List<Any?>? = null
)

data class EdgeRelatedProfiles(

	@field:SerializedName("edges")
	val edges: List<Any?>? = null
)

data class EdgeFollowedBy(

	@field:SerializedName("count")
	val count: Int? = null
)

data class User(

	@field:SerializedName("is_private")
	val isPrivate: Boolean? = null,

	@field:SerializedName("edge_felix_video_timeline")
	val edgeFelixVideoTimeline: EdgeFelixVideoTimeline? = null,

	@field:SerializedName("has_ar_effects")
	val hasArEffects: Boolean? = null,

	@field:SerializedName("is_business_account")
	val isBusinessAccount: Boolean? = null,

	@field:SerializedName("edge_related_profiles")
	val edgeRelatedProfiles: EdgeRelatedProfiles? = null,

	@field:SerializedName("has_requested_viewer")
	val hasRequestedViewer: Boolean? = null,

	@field:SerializedName("connected_fb_page")
	val connectedFbPage: Any? = null,

	@field:SerializedName("category_enum")
	val categoryEnum: Any? = null,

	@field:SerializedName("has_channel")
	val hasChannel: Boolean? = null,

	@field:SerializedName("followed_by_viewer")
	val followedByViewer: Boolean? = null,

	@field:SerializedName("external_url_linkshimmed")
	val externalUrlLinkshimmed: Any? = null,

	@field:SerializedName("external_url")
	val externalUrl: Any? = null,

	@field:SerializedName("business_category_name")
	val businessCategoryName: Any? = null,

	@field:SerializedName("profile_pic_url_hd")
	val profilePicUrlHd: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("requested_by_viewer")
	val requestedByViewer: Boolean? = null,

	@field:SerializedName("profile_pic_url")
	val profilePicUrl: String? = null,

	@field:SerializedName("follows_viewer")
	val followsViewer: Boolean? = null,

	@field:SerializedName("edge_media_collections")
	val edgeMediaCollections: EdgeMediaCollections? = null,

	@field:SerializedName("edge_saved_media")
	val edgeSavedMedia: EdgeSavedMedia? = null,

	@field:SerializedName("edge_follow")
	val edgeFollow: EdgeFollow? = null,

	@field:SerializedName("restricted_by_viewer")
	val restrictedByViewer: Any? = null,

	@field:SerializedName("blocked_by_viewer")
	val blockedByViewer: Boolean? = null,

	@field:SerializedName("biography")
	val biography: String? = null,

	@field:SerializedName("is_verified")
	val isVerified: Boolean? = null,

	@field:SerializedName("has_blocked_viewer")
	val hasBlockedViewer: Boolean? = null,

	@field:SerializedName("country_block")
	val countryBlock: Boolean? = null,

	@field:SerializedName("is_joined_recently")
	val isJoinedRecently: Boolean? = null,

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("has_clips")
	val hasClips: Boolean? = null,

	@field:SerializedName("highlight_reel_count")
	val highlightReelCount: Int? = null,

	@field:SerializedName("overall_category_name")
	val overallCategoryName: Any? = null,

	@field:SerializedName("edge_followed_by")
	val edgeFollowedBy: EdgeFollowedBy? = null,

	@field:SerializedName("edge_owner_to_timeline_media")
	val edgeOwnerToTimelineMedia: EdgeOwnerToTimelineMedia? = null,

	@field:SerializedName("business_email")
	val businessEmail: Any? = null,

	@field:SerializedName("has_guides")
	val hasGuides: Boolean? = null,

	@field:SerializedName("edge_mutual_followed_by")
	val edgeMutualFollowedBy: EdgeMutualFollowedBy? = null,

	@field:SerializedName("username")
	val username: String? = null
)

data class EdgeMutualFollowedBy(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("edges")
	val edges: List<Any?>? = null
)

data class EdgesItem(

	@field:SerializedName("node")
	val node: Node? = null
)

data class Owner(

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)

data class Graphql(

	@field:SerializedName("user")
	val user: User? = null
)

data class EdgeLikedBy(

	@field:SerializedName("count")
	val count: Int? = null
)

data class PageInfo(

	@field:SerializedName("has_next_page")
	val hasNextPage: Boolean? = null,

	@field:SerializedName("end_cursor")
	val endCursor: Any? = null
)
